export interface User {
    id: number;
    userName: string;
    email: string;
    role: string;   // should be Role according to data model, but not defined
    registrationDate: Date;
  }