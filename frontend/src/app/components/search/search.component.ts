import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {LabelType, Options} from '@angular-slider/ngx-slider';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchForm: FormGroup;

  minValue = 10000;
  maxValue = 50000;
  options: Options = {
    floor: 0,
    ceil: 200000,
  };

  constructor(private fb: FormBuilder) {
    this.searchForm = this.fb.group({
      // price: []
    });
  }

  ngOnInit(): void {
  }

}
