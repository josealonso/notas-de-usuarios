import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { DataService } from '../services/data.service';
import { Note } from '../model/Note';

@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html'
})
export class CreateUserComponent implements OnInit {
  userFormGroup: FormGroup;
  notes: Note[];

  constructor(private dataservice: DataService){}
  getNotes(){
    this.dataservice.getNotes().subscribe(data => {
      this.notes = data;
    });
  }
  ngOnInit() {
    this.userFormGroup = new FormGroup(
      {
        name : new FormControl(''),
        text : new FormControl('')
      },
    );
    this.getNotes();
}

addNote() {
  this.dataservice.addNote(this.userFormGroup.value).subscribe(data => {
    this.notes = data;
    console.log(this.notes);
  });
  this.getNotes();
}

}
