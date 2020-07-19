export class User {
  id: number;
  firstName: string;
  username: string;
  password: string;
  enabled: boolean;

  constructor(id?: number, firstName?: string, username?: string, password?: string, enabled?: boolean){
    this.id = id;
    this.firstName = firstName;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
  }
}
