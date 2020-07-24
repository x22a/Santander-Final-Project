export interface User{
    ownerId: number;
    balance: {
        amount: number,
        currency: string
    };
}
