import { TestBed } from '@angular/core/testing';

import { HttpService } from './http.service';

describe('HttpService', () => {
  let service: HttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpService);
  });

  describe('UserService', () => {
    let service: UserService;
  
    beforeEach(() => {
      TestBed.configureTestingModule({});
      service = TestBed.inject(UserService);
    });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
