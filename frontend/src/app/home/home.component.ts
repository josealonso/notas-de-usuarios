import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';
import { Note } from '../model/Note';

@Component({
  selector: 'app-get-user',   //  'app-get-user'  'app-home'
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  displayData: boolean;
  note: Note;
  notes: Note[] = [];
  constructor(private dataservice: DataService){}
  getNotes(){
    this.dataservice.getNotes().subscribe(data => {
      this.notes = data;
    });
  }
  fetchId = 0;

  getNote() {
    this.dataservice.getNote(this.fetchId).subscribe(data => {
      this.note = data;
     this.displayData=true;
    });
  }

  idtoUpdate = 0;
  updateNote() {
    this.dataservice.getNote(this.idtoUpdate).subscribe(data => {
      this.note = data;
      this.note.text = 'Updated Model';
      this.dataservice.updateNote(this.note).subscribe(data1 => {
        this.getNotes();
      });
    });
  }

  ngOnInit() {
    console.log("===== INICIO =====");
    this.getNotes();
    console.log("Notas: " + this.notes[0] );
    // this.getNote();
  }

}


// import { Component, OnInit } from '@angular/core';
// import { DataService } from '../data.service';
// import { UserData } from '../user-data.service';

// @Component({
//   selector: 'app-home',
//   templateUrl: './home.component.html'
// })
// export class HomeComponent implements OnInit {
//  constructor(){}
//  ngOnInit(){}

// }
