import { stat } from 'fs';

export class Job {
  id: number;
  companyName: string;
  dateApplied: Date;
  jobTitle: string;
  location: string;
  contact: string;
  coverLetter: boolean;
  status: string;

constructor(id?: number, companyName?: string, dateApplied?: Date, jobTitle?: string, location?: string, contact?: string, coverLetter?: boolean, status?: string){
  this.id = id;
  this.companyName = companyName;
  this.dateApplied = dateApplied;
  this.jobTitle = jobTitle;
  this.location = location;
  this.contact = contact;
  this.coverLetter = coverLetter;
  this.status = status;
  }
}
