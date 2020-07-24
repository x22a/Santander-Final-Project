import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { RequestService } from '../../services/request.service';
import { DataService } from '../../services/data.service';
import { Router } from '@angular/router';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';

import { User } from '../models/user.model';


@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  signInForm: FormGroup;
  accessToken: string;
  tokenType: string;
  isLogged: boolean;
  hasError: boolean;
  messageError: string;
  user: User;

  constructor(
    private fb: FormBuilder,
    private _snackBar: MatSnackBar,
    private service: RequestService,
    private dataService: DataService,
    private router: Router,
    private httpClient: HttpClient,
  ) {}

  ngOnInit(): void {
    this.signInForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', Validators.required],
      role: 'USER',
    });
    this.isLogged = false;
    this.dataService.isLogged.subscribe(
      (isLogged) => (this.isLogged = isLogged)
    );
    this.hasError = false;
    this.messageError = '';
  }




  async submitForm() {
    try {
      const result = await this.service.signRequest(this.signInForm.value);
      this.isLogged = true;
      this.authStateChange();
      this.router.navigate(['/']);
    } catch (error) {
      this.hasError = true;
      this.messageError = error;
      this.openSnackBar();
    }
  }

  openSnackBar() {
    this._snackBar.open(this.messageError, 'Close', {
      duration: 2000,
      horizontalPosition: this.horizontalPosition,
      verticalPosition: this.verticalPosition,
      panelClass: ['error-snackbar'],
    });
  }

  authStateChange() {
    this.dataService.changeState(true);
  }

  get username() {
    return this.signInForm.get('username');
  }

  get password() {
    return this.signInForm.get('password');
  }

  get password2() {
    return this.signInForm.get('password');
  }

}
