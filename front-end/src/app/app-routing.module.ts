import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { AccountComponent } from './account/account.component';
import { AuthGuard } from './auth.guard';
import { SignInComponent } from './sign-in/sign-in.component';
import { AccountInfoComponent } from './account-info/account-info.component';


const routes: Routes = [
  {
    path: 'sign-in',
    component: SignInComponent,
  },
  {
    path: '',
    component: LoginComponent,
  },
  {
    path: 'account',
    component: AccountComponent,
  },
  {
    path: 'account-info',
    component: AccountInfoComponent,
    canActivate: [AuthGuard],
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
