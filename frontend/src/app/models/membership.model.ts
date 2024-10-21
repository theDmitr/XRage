export class Membership {
    constructor(
        public id: number, 
        public name: string, 
        public price: number, 
        public description: string,
        public type: string,
        public duration: number,
        public availableVisits: number,
    ) {}
}