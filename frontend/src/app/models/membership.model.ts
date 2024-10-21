export class Membership {
    constructor(
        public id: number, 
        public name: string, 
        public price: number, 
        public duration: number, 
        public description: string,
    ) {}
}