import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-video-player',
  standalone: true,
  imports: [],
  templateUrl: './video-player.component.html',
  styleUrl: './video-player.component.css'
})

export class VideoPlayerComponent implements OnInit {

  constructor(private urlReader: ActivatedRoute) {}

  ngOnInit(): void {
    console.log(this.urlReader.snapshot.params['id']);
  }

  handleClick(event: any) {
    event.preventDefault();
  }

}

