/*
 * Copyright (c) 2017, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 * <p>
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.ballerina.core.model.statements;

import org.wso2.ballerina.core.model.NodeExecutor;
import org.wso2.ballerina.core.model.NodeLocation;
import org.wso2.ballerina.core.model.NodeVisitor;
import org.wso2.ballerina.core.model.Worker;
import org.wso2.ballerina.core.model.expressions.CallableUnitInvocationExpr;
import org.wso2.ballerina.core.model.expressions.Expression;
import org.wso2.ballerina.core.model.expressions.VariableRefExpr;
import org.wso2.ballerina.core.model.types.BType;
import org.wso2.ballerina.core.model.values.BValue;

/**
 * A {@code WorkerInvocationStmt} Class to hold data related to worker invocation statement
 * <p>
 * message -> sampleWorker;
 *
 *  @since 0.8.0
 */
public class WorkerInvocationStmt extends AbstractStatement implements CallableUnitInvocationExpr<Worker> {

    private String workerName;
    private Worker calleeWorker;
    private VariableRefExpr inMsg;
    private BType[] types = new BType[0];

    public WorkerInvocationStmt(String workerName, NodeLocation nodeLocation) {
        super(nodeLocation);
        this.workerName = workerName;
    }


    public String getCallableUnitName() {
        return workerName;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPackageName() {
        return null;
    }

    @Override
    public String getPackagePath() {
        return null;
    }

    /**
     * Returns an array of arguments of this callable unit invocation expression.
     *
     * @return the array of arguments
     */
    @Override
    public Expression[] getArgExprs() {
        return new Expression[0];
    }

    @Override
    public Worker getCallableUnit() {
        return calleeWorker;
    }

    @Override
    public void setCallableUnit(Worker callableUnit) {
        this.calleeWorker = callableUnit;
    }

    @Override
    public BType[] getTypes() {
        return this.types;
    }

    @Override
    public void setTypes(BType[] types) {
        this.types = types;
    }

    @Override
    public BValue[] executeMultiReturn(NodeExecutor executor) {
        return null;
    }

    public VariableRefExpr getInMsg() {
        return inMsg;
    }

    public void setInMsg(VariableRefExpr inMsg) {
        this.inMsg = inMsg;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void execute(NodeExecutor executor) {
        executor.visit(this);
    }
}


