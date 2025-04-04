export class User {
    id!: number;
    username!: string;
    email!: string;
    role!: string;   // (Role according to data model)
    registrationDate!: Date;
    feedbacks!: string[];
    translations!: string[];
  }