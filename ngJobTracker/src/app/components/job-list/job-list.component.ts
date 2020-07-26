import { Component, OnInit } from '@angular/core';
import { JobService } from 'src/app/services/job.service';
import { Job } from 'src/app/models/job';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
  styleUrls: ['./job-list.component.css']
})
export class JobListComponent implements OnInit {

  selected = null;
  job = new Job();
  jobList: Job[] = [];

  constructor(
    private jobSvc: JobService
  ) { }

  ngOnInit(): void {
    this.loadJobs();
  }

  loadJobs(){
    this.jobSvc.index().subscribe(
      jobs => {
        this.jobList = jobs;
      },
      onfail => {
        console.log(this.jobList);
        console.error('Observer got an error: ' + onfail);
      }
    );
  }

}
