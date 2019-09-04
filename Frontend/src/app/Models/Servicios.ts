export class Servicio{

	id_servicio:String;
	nombre:String;
	
	constructor(id_servicio = '', nombre = ''){
		this.id_servicio = id_servicio;
        this.nombre = nombre;
	}
}