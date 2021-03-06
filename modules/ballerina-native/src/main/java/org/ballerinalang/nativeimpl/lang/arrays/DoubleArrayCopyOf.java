/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.nativeimpl.lang.arrays;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.TypeEnum;
import org.ballerinalang.model.values.BArray;
import org.ballerinalang.model.values.BDouble;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.Attribute;
import org.ballerinalang.natives.annotations.BallerinaAnnotation;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

/**
 * Native function ballerina.model.arrays:copyOf(double[]).
 */
@BallerinaFunction(
        packageName = "ballerina.lang.arrays",
        functionName = "copyOf",
        args = {@Argument(name = "doubleArray", type = TypeEnum.ARRAY, elementType = TypeEnum.DOUBLE)},
        returnType = {@ReturnType(type = TypeEnum.ARRAY, elementType = TypeEnum.DOUBLE)},
        isPublic = true
)
@BallerinaAnnotation(annotationName = "Description", attributes = {@Attribute(name = "value",
        value = "Copies the specified double array") })
@BallerinaAnnotation(annotationName = "Param", attributes = {@Attribute(name = "doubleArray",
        value = "The array to be copied") })
@BallerinaAnnotation(annotationName = "Return", attributes = {@Attribute(name = "double[]",
        value = "A copy of the specified array") })
public class DoubleArrayCopyOf extends AbstractNativeFunction {
    @Override
    public BValue[] execute(Context context) {
        BArray array = (BArray) getArgument(context, 0);
        BArray<BDouble> newArray = new BArray<>(BDouble.class);
        for (int i = 0; i < array.size(); i++) {
            newArray.add(i, array.get(i));
        }
        return getBValues(newArray);
    }
}
