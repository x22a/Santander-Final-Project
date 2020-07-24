import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { DialogData } from '../models/dialog.data.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RequestService } from '../../services/request.service';
import { Transaction } from '../models/transaction.model';
import { Amount } from '../models/amount.model';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transactionForm: FormGroup;
  transaction: Transaction;
  transactionAmount: Amount;
  constructor(
    private fb: FormBuilder, private service: RequestService,
    private dialogRef: MatDialogRef<TransactionComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) { }

  ngOnInit(): void {
    this.transactionForm = this.fb.group({
      senderAccountId: this.data,
      receiverAccountId: ['', [Validators.required, Validators.min(0), Validators.pattern('[0-9]+')]],
      amount: ['', [Validators.required, Validators.min(0), Validators.pattern('[0-9]+')]],
      concept: ['', [Validators.required]],
    });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  newTransaction() {
    this.transactionAmount = new Amount(this.transactionForm.value.amount);
    this.transaction = new Transaction(this.transactionForm.value.senderAccountId.id, this.transactionForm.value.receiverAccountId,
      this.transactionAmount, this.transactionForm.value.concept);
    console.log(this.transaction);
    this.service.postRequest('transactions/', this.transaction).subscribe(res => {
      this.data = res.message;
      this.dialogRef.close(this.data);
     },
      err => {console.log(err); }
    );
  }

  get receiverId() {
    return this.transactionForm.get('receiverId');
  }
  get receiverAccountId() {
    return this.transactionForm.get('receiverAccountId');
  }
  get amount() {
    return this.transactionForm.get('amount');
  }
  get concept() {
    return this.transactionForm.get('concept');
  }


}
