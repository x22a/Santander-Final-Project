import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RequestService } from '../../services/request.service';
import { DataService } from '../../services/data.service';
import { Router } from '@angular/router';
import {
  MatSnackBar,
  MatSnackBarHorizontalPosition,
  MatSnackBarVerticalPosition,
} from '@angular/material/snack-bar';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  horizontalPosition: MatSnackBarHorizontalPosition = 'center';
  verticalPosition: MatSnackBarVerticalPosition = 'bottom';
  loginForm: FormGroup;
  accessToken: string;
  tokenType: string;
  isLogged: boolean;
  hasError: boolean;
  messageError: string;

  constructor(
    private fb: FormBuilder,
    private _snackBar: MatSnackBar,
    private service: RequestService,
    private dataService: DataService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', Validators.required],
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
      const result = await this.service.authRequest(this.loginForm.value);
      this.isLogged = true;
      this.authStateChange();
      this.router.navigate(['/account']);
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
    return this.loginForm.get('username');
  }

  get password() {
    return this.loginForm.get('password');
  }


}
