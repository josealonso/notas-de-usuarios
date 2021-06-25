import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { Note } from '../model/Note';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html'
})
export class DeleteUserComponent implements OnInit {
  notes: Note[];
  // note: NoteFetch;
  displayData: boolean;


  constructor(private dataservice: DataService) { }

  ngOnInit() {
    this.getNotes();
   // this.getNote();
    this.deleteNote();
  }
 idtodelete=0;
  deleteNote() {

    this.dataservice.deleteNote(this.idtodelete).subscribe(data => {
      this.getNotes();
    });
  }

  getNotes(){
    this.dataservice.getNotes().subscribe(data => {
      this.notes = data;
    });
  }

}
