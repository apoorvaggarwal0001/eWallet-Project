import { TestBed } from '@angular/core/testing';

import { TransferFundServiceService } from './transfer-fund-service.service';

describe('TransferFundServiceService', () => {
  let service: TransferFundServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransferFundServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
