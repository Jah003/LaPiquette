/* eslint-disable no-console */
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss'],
})
export class TestComponent implements OnInit {
  constructor() {
    console.log('oui');
  }

  ngOnInit(): void {
    // eslint-disable-next-line no-console
    console.log('oui');
  }
}
