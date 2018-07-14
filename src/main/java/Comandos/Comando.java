
package Comandos;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface Comando {
    void exec(HttpServletRequest request, HttpServletResponse response);
}
