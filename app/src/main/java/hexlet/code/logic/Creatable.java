package hexlet.code.logic;

import java.util.Map;

/**
 * В интерфейсе объявлен всего один метод, который необходимо реализовать в каждой игре
 * для генерации примеров и ответов, которые будут передаваться для фильтрации некорректных
 * ответов игрока.
 */
public interface Creatable {
    /**
     * Данный контракт служит для стандартизации и упрощения подхода
     * к созданию логики игр, поскольку логика создаваемых
     * простейших консольных игр требует вывод вопроса и сравнения ответа,
     * что в свою очередь, может быть отображено через реализацию Мар.
     * @return Map.
     */
    Map<String, Object> fill();
}
