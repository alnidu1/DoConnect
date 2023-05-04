import { Component } from '@angular/core';

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.css']
})
export class UserSearchComponent {

  searchQuery: string='';
  exampleposts: any[] = [
    {title: 'Post 1', description: 'This is the first post'},
    {title: 'Post 2', description: 'This is the second post'},
    {title: 'Post 3', description: 'This is the third post'}
  ];

  examplesearchPosts() {
    return this.exampleposts.filter(post => {
      return post.title.toLowerCase().includes(this.searchQuery.toLowerCase()) ||
             post.description.toLowerCase().includes(this.searchQuery.toLowerCase());
    });
  }
}
