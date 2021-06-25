import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { tap, catchError, map } from 'rxjs/operators';
import { Note } from '../model/Note';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  baseUrl = 'http://localhost:8080/api/v1/notesApp';
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Accept', 'application/json');
  httpOptions = {
    headers: this.headers
  };

  constructor(private http: HttpClient) { }      //Injecting HTTP service to communicate with the data

  private handleError(error: any) {
    console.error(error);       // Created a function to handle and log errors
    return throwError(error);
  }
  
  getNotes(): Observable<any> {
    // return this.http.get(`${this.baseUrl}`);
    const url = `${this.baseUrl}` + '/notes';
    return this.http.get(url).pipe(
      tap(data => console.log(data)),
      catchError(this.handleError)
    );
  }
  
  getNote(id: number): Observable<any> {
    const url = `${this.baseUrl}/${id}`;
    console.log("getNote: " + url); 
    return this.http.get<any>(url).pipe(
    catchError(this.handleError)
    );
  }

  addNote(note: Note): Observable<any> {
    const url = `${this.baseUrl}` + '/newNote';
    note.id = null;
    return this.http.post<any>(url, note, this.httpOptions).pipe(
      tap(data => console.log(data)),
      catchError(this.handleError)
    );
  }

  deleteNote(id: number): Observable<any> {
    const urlStart = `${this.baseUrl}` + '/notes';
    const url = `${urlStart}/${id}`;
    return this.http.delete<any>(url, this.httpOptions).pipe(
      catchError(this.handleError)
    );
  }

  updateNote(note: Note): Observable<any>{
    const url = `${this.baseUrl}` + '/notes';
    return this.http.put<any>(url, note, this.httpOptions).pipe(
      map(() => note),
      catchError(this.handleError)
    );
  }
}
