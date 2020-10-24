package br.ucsal.bes20202.aula11.dmitryrocha;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Classe1.class })

//AULA PAROU EM 1:22:00
public class Classe1Test {
    @Test
    public void testarMetodo4() throws Exception {
        Classe1 objeto1 = new Classe1();
        Classe1 spy1 = PowerMockito.spy(objeto1);

        PowerMockito.mockStatic(Classe1.class);
        PowerMockito.when(Classe1.metodo1()).thenReturn(10);
        PowerMockito.when(Classe1.class, "metodo2").thenReturn(20);
        PowerMockito.when(spy1, "metodo3").thenReturn(30);

        spy1.metodo4();

        PowerMockito.verifyPrivate(Classe1.class).invoke("metodo2");
        PowerMockito.verifyPrivate(spy1).invoke("metodo3");
        PowerMockito.verifyStatic(Classe1.class);
        Classe1.metodo1();
        PowerMockito.verifyNoMoreInteractions(Classe1.class);

    }
}
