package cl.uchile.dcc.scrabble.gui.Tipos;

public interface ILogical {

    ILogical and(ILogical logical);

    ILogical andSBool(SBool Sbool);

    ILogical andSBinary(SBinary Sbinary);

    ILogical or(ILogical logical);

    ILogical orSBool(SBool Sbool);

    ILogical orSBinary(SBinary Sbinary);

    ILogical negacion();
}
