export class Membership {
    constructor(
        public id: number, 
        public name: string, 
        public cost: number, 
        public duration: number, 
        public description: string,
        public isDeleted: boolean
    ) {}
}