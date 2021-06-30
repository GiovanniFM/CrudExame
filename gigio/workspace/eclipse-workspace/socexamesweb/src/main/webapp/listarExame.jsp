<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>

<body>
	<h1>SOCExame Java Dev</h1>

	<h2>Listagem de exames:</h2>
	<table>

		<s:iterator value="pacientes" var="pacienteVar">
			<tr>
				<td>Código: <s:property value="idPaciente" /></td>
				<td>Nome: <s:property value="nmPaciente" /></td>
				<td><s:iterator value="#pacienteVar.examePaciente"
						var="exameVar">
						<s:property value="#exameVar.nmExame" />
					</s:iterator></td>
			</tr>

		</s:iterator>

	</table>

</body>
</html>