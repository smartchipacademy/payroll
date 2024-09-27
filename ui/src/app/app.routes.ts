import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { EmpComponent } from './emp/emp.component';
import { EmpFormComponent } from './emp-form/emp-form.component';
import { SuperadminComponent } from './superadmin/superadmin.component';
import { SuperadminFormsComponent } from './superadmin-forms/superadmin-forms.component';
import { SuperuserComponent } from './superuser/superuser.component';
import { SuperuserFormComponent } from './superuser-form/superuser-form.component';
import { StudentComponent } from './student/student.component';
import { StudentFormComponent } from './student-form/student-form.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SampleComponent } from './sample/sample.component';

export const routes: Routes = [


{
    path: "empForm",component:EmpFormComponent
},
{
    path: "superadmin",component:SuperadminComponent
},
{
    path: "",component:SuperadminFormsComponent
},
{
    path: "superuser",component:SuperuserComponent
},
{
    path: "superuser-form",component:SuperuserFormComponent
},
{
   path: "students",component:StudentComponent
},
{
    path: "student-form",component:StudentFormComponent
},
{
    path: 'loginn',component:LoginFormComponent
},
{
    path: '',component:DashboardComponent
},
{
    'path': 'dashboard', component: DashboardComponent,
    children: [
      {
        path: 'sample',
        component: LoginFormComponent
      },{
        path: 'emps',component: EmpComponent
    },
    
    ]
  },

];