import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { AngularFireDatabase, FirebaseObjectObservable } from 'angularfire2/database';
import { SpinnerDialog } from 'ionic-native';
import { IService } from '../../services/IService';

@Component({
  templateUrl: 'item-details-register.html'
})

export class ItemDetailsPageRegister {

    page: any;
    service: IService;
    params: any;
    data: FirebaseObjectObservable<any>;

    constructor(public af: AngularFireDatabase, public navCtrl: NavController, navParams: NavParams) {
      // If we navigated to this page, we will have an item available as a nav param
      this.page = navParams.get('page');
      this.service =  navParams.get('service');
      this.params = this.service.prepareParams(this.page, navCtrl);
      this.loadDataFromFirebase();
      SpinnerDialog.show(null, "Loading");
    }

    loadDataFromFirebase() {
      this.af.object('register/' + this.params.theme).subscribe(snapshot => {
          SpinnerDialog.hide();
          this.params.data = {};
          this.params.data = snapshot;
      });
    }
}
