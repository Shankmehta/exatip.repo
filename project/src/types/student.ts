export interface Student {
  sno: number;
  sname: string;
  saddress: string;
  fees: number;
}

export interface LoginCredentials {
  username: string;
  password: string;
}

export interface StudentResponse {
  success: boolean;
  message: string;
  data?: Student[];
}