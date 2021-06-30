<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<body>
	<h1>SOCExame Java Dev</h1>

	<h2>Listagem de exames:</h2>
	<table>

		<s:iterator value="pacientes" status="pacienteStatus">
			<tr>
				<td>Código: <s:property value="idPaciente" /></td>
				<td>Nome: <s:property value="nmPaciente" /></td>
				<td><s:iterator value="#pacienteStatus.examePaciente"
						status="exameStatus">
						<s:property value="nmExame" />
						<s:if test="!#exameStatus.last">,</s:if>
					</s:iterator></td>
			</tr>

		</s:iterator>

	</table>

</body>
</html>