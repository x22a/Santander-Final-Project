import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { MatMenuModule } from '@angular/material/menu';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatDialogModule } from '@angular/material/dialog';

import {MatPaginatorModule} from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from './navbar/navbar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';
import { SignInComponent } from './sign-in/sign-in.component';
import { AccountComponent } from './account/account.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RequestService } from 'src/services/request.service';
import { AccountInfoComponent } from './account-info/account-info.component';
import { TransactionComponent } from './transaction/transaction.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    SignInComponent,
    AccountComponent,
    AccountInfoComponent,
    TransactionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
    LayoutModule,
    MatSidenavModule,
    MatListModule,
    MatSnackBarModule,
    HttpClientModule,
    MatFormFieldModule,
    MatTableModule,
    MatMenuModule,
    MatDividerModule,
    MatExpansionModule,
    NgbModule,
    RouterModule,
    MatPaginatorModule,
    MatDialogModule
  ],
  providers: [AuthGuard, RequestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
