import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {InMemoryWebApiModule} from 'angular-in-memory-web-api';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { NoteData } from './services/data.service';

import { from } from 'rxjs';
import { HomeComponent } from './home/home.component';

import { HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CreateUserComponent } from './create-user/create-user.component';
import { EditNoteComponent } from './edit-note/edit-note.component';
import { DeleteUserComponent } from './delete-user/delete-user.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EditNoteComponent,
    CreateUserComponent,
    DeleteUserComponent
  ],
  imports: [
    BrowserModule,
    // AppRoutingModule, InMemoryWebApiModule.forRoot(NoteData), HttpClientModule, FormsModule, ReactiveFormsModule
    AppRoutingModule, HttpClientModule, FormsModule, ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
