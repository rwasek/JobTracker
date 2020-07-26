import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Job } from '../models/job';


@Injectable({
  providedIn: 'root'
})
export class JobService {

  private baseUrl = 'http://localhost:8091/';
  private url = this.baseUrl + 'api/jobs';

  constructor(
    private http: HttpClient
  ) { }


  index() {
    return this.http.get<Job[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('error in job service index method');
      })
    );
  }

}
