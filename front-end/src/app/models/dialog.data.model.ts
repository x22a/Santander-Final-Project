export interface DialogData {
    receiverId: number;
    receiverAccountId: number;
    amount: {
        amount: number,
        currency: string
    };
    concept: string;
}