import { Component, OnInit } from "@angular/core";
import { Membership } from "../../models/membership.model";
import { MembershipService } from "../../services/membership.service";
import { CommonModule, NgFor } from "@angular/common";
import { IonicModule } from "@ionic/angular";

@Component({
    selector: "services-component",
    templateUrl: "./services.component.html",
    styleUrl: "./services.component.scss",
    standalone: true,
    imports: [CommonModule, IonicModule, NgFor],
})
export class ServicesComponent implements OnInit {
    memberships: Membership[] = [];

    constructor(private membershipService: MembershipService) {}

    ngOnInit(): void {
        this.membershipService.getAll().then(m => this.memberships = m);
    }
}