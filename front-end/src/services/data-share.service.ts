import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataShareService {

  accountId: number;
  balance: object;

  constructor() { }

  public setAccount(id: number){
    this.accountId = id;
  }

  public getAccount(){
    return this.accountId;
  }

  public setBalance(balance){
    this.balance = balance;
    console.log(this.balance);
  }

  public getBalance(){
    return this.balance;
  }
}
