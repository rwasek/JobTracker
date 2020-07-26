import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { JobListComponent } from './components/job-list/job-list.component';


const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'jobs'},
  { path: 'jobs', component: JobListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
