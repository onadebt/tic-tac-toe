package cz.muni.fi.pv260.team4.tictactoe.movestrategy;

import cz.muni.fi.pv260.team4.tictactoe.entity.MatchConfiguration;
import cz.muni.fi.pv260.team4.tictactoe.interfaces.IOProvider;
import cz.muni.fi.pv260.team4.tictactoe.validators.NValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NGatherer implements MoveParameterGatherer<Integer> {
    private final IOProvider ioProvider;
    private final MatchConfiguration configuration;

    /**
     * Maximum N, use null to signify unlimited.
     */
    private final Integer maxN;

    /**
     * Asks user for N.
     *
     * @return N
     */
    @Override
    public Integer gatherMoveParameters() {
        return this.ioProvider.readInt(
                "Enter count: ", new NValidator(null)
        );
    }
}
