import {IService} from './IService';

export class MenuService implements IService {

    constructor() {}

    getId = ():string => 'menu';

    getTitle = ():string => 'UIAppTemplate';

    getAllThemes = (): Array<any> => {
      return [
        {"title" : "Login Pages", "theme"  : "login",  "icon" : "icon-lock-open-outline", "listView" : false, "component":""},
        {"title" : "Register Pages", "theme"  : "register",  "icon" : "icon-comment-account", "listView" : false, "component":""},
      ];
    };

    getDataForTheme = (menuItem: any): Array<any> => {
      return [];
    };

    getEventsForTheme = (menuItem: any): any => {
      return {};
    };

    prepareParams = (item: any) => {
      return {
          title: item.title,
          data: this.getDataForTheme(item),
          events: this.getEventsForTheme(item)
      };
    };
}
