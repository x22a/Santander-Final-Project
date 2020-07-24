import { Component, OnInit, Input } from '@angular/core';
import { RequestService } from '../../services/request.service';
import { DataShareService } from '../../services/data-share.service';
import { Transaction } from '../models/transaction.model';
import {
  MatDialog,
  MatDialogRef,
  MAT_DIALOG_DATA,
} from '@angular/material/dialog';
import { TransactionComponent } from '../transaction/transaction.component';


@Component({
  selector: 'app-account-info',
  templateUrl: './account-info.component.html',
  styleUrls: ['./account-info.component.css']
})
export class AccountInfoComponent implements OnInit {
  accountId: number;
  balance: object;
  transactions: Transaction[] = [];
  showTable: boolean = true;
  displayedColumns = ['date', 'senderAccountId', 'receiverId', 'receiverAccountId', 'concept', 'amount'];

  constructor(
    private service: RequestService,
    private accountService: DataShareService,
    private dialog: MatDialog,
  ) {
  }

  ngOnInit(): void {
    this.accountId = this.accountService.getAccount();
    this.balance = this.accountService.getBalance();
    this.service.getRequest('transactions/sender/account/' + this.accountId).subscribe(
      (res) => {
        this.transactions = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }




  openDialog(id): void {
    const dialogRef = this.dialog.open(TransactionComponent, {
      data: { id },
      height: '300px',
      width: '250px',
    });

    dialogRef.afterClosed().subscribe((result) => {
      this.transactions = [... this.transactions, result];
      });
    }
}
