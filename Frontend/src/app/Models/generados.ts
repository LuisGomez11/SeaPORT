export class Generados {
    constructor(fechaFinal = '', id_entidadM = '', id_entidadG = '', id_servicio = '', terminal = '', lloyd = '', uvi = '', referencia = '', muelle = '', fechaCita = '', horaCita = '', hrsOp = '', horaFinal = '', estado = ''){
        this.estado = estado;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.fechaFinal = fechaFinal;
        this.horaCita = horaCita;
        this.horaFinal = horaFinal;
        this.hrsOp = hrsOp;
        this.id_entidadG = id_entidadG;
        this.id_entidadM = id_entidadM;
        this.id_servicio = id_servicio;
        this.lloyd = lloyd;
        this.muelle = muelle;
        this.referencia = muelle;
        this.terminal = terminal;
        this.uvi = uvi;
    }
    terminal: string;
    id_entidadM: string;
    lloyd: String;
    uvi: String;
    referencia: String;
    muelle: String;
    id_entidadG: string;
    fechaCita: string;
    horaCita: String;
    hrsOp: string;
    fechaFinal: string;
    horaFinal: string;
    id_servicio: string;
    estado: string;
}
