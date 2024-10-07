import { Component, OnInit } from "@angular/core";
import { Membership } from "../../../shared/models/membership.model";
import { MembershipService } from "../../services/membership/membership.service";

@Component({
    selector: "services-component",
    templateUrl: "./services.component.html",
    styleUrl: "./services.component.scss"
})
export class ServicesComponent implements OnInit {
    memberships: Membership[] = [];

    constructor(private membershipService: MembershipService) {}

    ngOnInit(): void {
        this.membershipService.getAll().subscribe(memberships => {
            this.memberships = memberships;
        });
    }
}