import { AirlineDevelopmentSecurityPage } from './app.po';

describe('airline-development-security App', () => {
  let page: AirlineDevelopmentSecurityPage;

  beforeEach(() => {
    page = new AirlineDevelopmentSecurityPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
