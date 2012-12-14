package edu.bedelias.enums;

public enum TurnoEnum {

	MATUTINO, VESPERTINO, NOCTURNO;
	
	// lo uso para obtener el turno desde una task
    public static TurnoEnum getTurno(String turno) {
            switch (turno) {
            case "matutino":
                    return TurnoEnum.MATUTINO;

            case "vespertino":
                    return TurnoEnum.VESPERTINO;

            case "nocturno":
                    return TurnoEnum.NOCTURNO;
            }
            return null;
    }
}
