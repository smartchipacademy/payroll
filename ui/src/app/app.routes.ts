import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
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
import { VideoPlayerComponent } from './video-player/video-player.component';
import { PdfViewerComponent } from './pdf-viewer/pdf-viewer.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';


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
    path: 'login-form',component:LoginFormComponent
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
        path: 'emp/:id',component: EmpComponent
    },

    {
        path: "video_player/:id", component: VideoPlayerComponent
    },
    
    {
        path: "pdf_viewer/:id", component: PdfViewerComponent
    },
    {
        path:"admin-dashboard",component:AdminDashboardComponent
    },
    
    
    ]
  },

];

@NgModule({
    imports:[RouterModule.forRoot(routes)],
    exports:[RouterModule]
    })
    
    export class AppRoutingModule{}