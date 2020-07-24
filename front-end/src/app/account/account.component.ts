import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { RequestService } from '../../services/request.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router, Data } from '@angular/router';
import { DataShareService } from '../../services/data-share.service';
import { from } from 'rxjs';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  showTable: boolean = true;
  accountForm: FormGroup;
  accounts: Account[] = [];
  value: number;
  selected: string;
  displayedColumns = ['id', 'balance', 'action'];
  username = this.service.username;

  @Output()
  accountIdEmitter: EventEmitter<number> = new EventEmitter();

  constructor(
    private service: RequestService,
    private fb: FormBuilder,
    private modalService: NgbModal,
    private router: Router,
    private accountService: DataShareService,
  ) {}

  ngOnInit(): void {
    this.service.getRequest('accounts/owner/' + this.username).subscribe(
      (res) => {
        this.accounts = res;
      },
      (err) => {
        console.log(err);
      }
    );

  }

  accountInfo(element){
    this.accountService.setAccount(element.id);
    this.accountService.setBalance(element.balance);
    this.router.navigate(['/account-info']);
  }

}
