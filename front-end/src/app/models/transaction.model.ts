import { Amount } from './amount.model';
export class Transaction{
    senderAccountId: number;
    receiverAccountId: number;
    amount: Amount;
    concept: string;

    constructor(senderAccountId: number, receiverAccountId: number, amount: Amount, concept: string){
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.amount = amount;
        this.concept = concept;

    }
}
