import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name: string = 'Simon Duffy';
  itemList: string[] = ['item1', 'item2', 'item3', 'item4'];
}
