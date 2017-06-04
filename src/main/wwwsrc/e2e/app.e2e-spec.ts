import { WwwsrcPage } from './app.po';

describe('wwwsrc App', () => {
  let page: WwwsrcPage;

  beforeEach(() => {
    page = new WwwsrcPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
